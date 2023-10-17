  function LoadCategories(){
            fetch("http://fakestoreapi.com/products/categories")
            .then(function(response){
                return response.json();
            })
            .then(function(categories){
                categories.unshift("all");
                categories.map(function(category){
                    var option = document.createElement("option");
                    option.text = category.toUpperCase();
                    option.value = category;
                    document.getElementById("lstCategories").appendChild(option);
                })
            })
        }

        function LoadProducts(url){
            document.querySelector("main").innerHTML="";
            fetch(url)
            .then(function(response){
                return response.json();
            })
            .then(function(products){
                 products.map(function(product){
                     var div = document.createElement("div");
                     div.className = "card m-2 p-2";
                     div.style.width = "200px";
                     div.innerHTML = `
                       <img src=${product.image} class="card-img-top" height="140">
                       <div class="card-header overflow-auto" style="height:100px">
                          <p>${product.title}</p>
                       </div>
                       <div class="card-body">
                          <dl>
                            <dt> Price  </dt>
                            <dd> ${product.price} <span>$</span></dd>
                            <dt> Rating </dt>
                            <dd> ${product.rating.rate} <span class="bi bi-star-fill text-success"></span> [${product.rating.count}]
                          </dl>
                       </div>
                       <div class="card-footer">
                          <button onclick="AddClick(${product.id})" class="btn btn-danger w-100">
                             <span class="bi bi-cart4"></span> Add to Cart
                          </button>
                       </div>
                     `;
                     document.querySelector("main").appendChild(div);
                 })
            })
        }

        function bodyload(){
            LoadCategories();
            LoadProducts("http://fakestoreapi.com/products");
            GetCartCount();
        }
        function CategoryChanged(){
            var categoryName = document.getElementById("lstCategories").value;
            if(categoryName=="all"){
                LoadProducts("http://fakestoreapi.com/products&quot");
            } else {
            LoadProducts(`http://fakestoreapi.com/products/category/${categoryName}`);
            }
        }
        function CategoryClicked(categoryName){
            if(categoryName=="all") {
                LoadProducts("http://fakestoreapi.com/products");
            } else {
                LoadProducts(`http://fakestoreapi.com/products/category/${categoryName}`);
            }
        }
        var CartItems = [];

        function GetCartCount(){
            document.getElementById("cartCount").innerHTML = CartItems.length;
        }

        function AddClick(id){
            fetch(`http://fakestoreapi.com/products/${id}`)
            .then(function(response){
                return response.json();
            })
            .then(function(product){
                CartItems.push(product);
                alert(`${product.title}\nAdded to Cart`);
                GetCartCount();
            })
        }
        function CartClick(){
            document.querySelector("tbody").innerHTML="";
            CartItems.map(function(product){
                var tr = document.createElement("tr");
                var tdTitle = document.createElement("td");
                var tdPreview = document.createElement("td");
                var tdPrice =document.createElement("td");

                tdTitle.innerHTML = product.title;
                tdPreview.innerHTML = `<img src=${product.image} width="50" height="50">`;
                tdPrice.innerHTML = product.price;

                tr.appendChild(tdTitle);
                tr.appendChild(tdPreview);
                tr.appendChild(tdPrice);

                document.querySelector("tbody").appendChild(tr);
            })
        }
