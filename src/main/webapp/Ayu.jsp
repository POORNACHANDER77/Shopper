<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopper | Online Shopping</title>
    <link rel="stylesheet" href="aj.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        a:link{
         color:white;
         text-decoration: none;
        }
        a:hover {
            color:yellow;
        }
    </style>
    <link rel="stylesheet" href="font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/bootstrap.css">
   <script type="text/javascript" src="shopper.js"></script>
</head>
<body class="container-fluid" onload="bodyload()">
    <header class="d-flex justify-content-between mt-2 bg-dark text-white p-2">
        <div>
            <h2>Shopper.</h2>
        </div>
        <div style="font-size: 20px;">
            <a class="me-3" href="javascript:CategoryClicked('all')">Home</a>
            <a class="me-3" href="javascript:CategoryClicked('electronics')">Electronics</a>

            <a class="me-3" href="javascript:CategoryClicked('jewelery')">Jewelery</a>
        </div>
        <div>
            <span class="bi bi-person-fill"></span>
            <span class="bi bi-heart"></span>
            <button data-bs-target="#YourCart" onclick="CartClick()" data-bs-toggle="modal" class="position-relative btn btn-warning">
                <span class="bi bi-cart4"></span> Your Cart
                <span id="cartCount" class="badge position-absolute top-0 end-0 bg-danger rounded rounded-circle"></span>
            </button>
            <div class="modal fade" id="YourCart">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h2 class="text-primary">Your Cart Items</h2>
                            <button class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Title</th>
                                        <th>Preview</th>
                                        <th>Price</th>
                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <section class="mt-3 row">
        <nav class="col-2">
           <label class="form-label fw-bold">Select Category</label>
           <div>
              <select onchange="CategoryChanged()" id="lstCategories" class="form-select">

              </select>
           </div>
        </nav>
        <main class="col-10 d-flex flex-wrap overflow-auto" style="height:500px">

        </main>
    </section>
    <script src="jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <footer>
     <div>
            <div class="brand-title">
            <h4> Shopper.</h4>
            </div>
          


           

        </div>
        <div>
            <div class="foot-title"><h4>Support</h4></div>
           
            <div><a href="faq.jsp">FAQs</a></div>
            <div><a href="shipping.jsp">Shipping</a></div>
        </div>
        <div>
            <div class="foot-title"><h4>Shop</h4></div>
            <div><a href="Ayu.jsp">Mens Shopping</a></div>
            <div><a href="Ayu.jsp">Womens Shopping</a></div>
            <div><a href="Ayu.jsp">Electronics</a></div>
            

        </div>
        <div>
            <div class="foot-title"><h4>Company</h4></div>
            <div><a href="Aboutus.jsp">About US</a></div>
            <div><a href="p.jsp"> privacy&policy</a></div>                                        

        </div>
        <div>
            <div class="foot-title"><h4>Contact Support</h4></div>
            <div>040246</div>
            <div>9390717974</div>
        </div>
    </footer>
</body>

</html>