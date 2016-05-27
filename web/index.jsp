<%-- 
    Document   : index
    Created on : Apr 21, 2016, 8:50:33 PM
    Author     : edwin < edwinkun at gmail dot com >
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrasi Pengguna</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
        <style>
            input::-webkit-outer-spin-button,
            input::-webkit-inner-spin-button {
                -webkit-appearance: none;
                margin: 0; 
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="inc/header.jsp" />
        <!-- End of Header -->
        
        <!-- Container -->
        <div class="container" style="padding-top: 60px;">
            <form class="form-horizontal" id="form1">
                <fieldset>

                    <legend>Registrasi</legend>
                    
                    <div class="alert alert-success" role="alert" id="suksesdiv">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        Sukses
                    </div>
                    <div class="alert alert-danger" role="alert" id="gagaldiv">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        Gagal
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="textinput">Nama</label>  
                        <div class="col-md-4">
                            <input id="nama" name="textinput" placeholder="Nama Anda" class="form-control input-md" type="text">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="textinput">Email</label>  
                        <div class="col-md-4">
                            <input id="email" name="textinput" placeholder="Email Anda" class="form-control input-md" type="email">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="prependedtext">Nomer Telepon</label>
                        <div class="col-md-4">
                            <div class="input-group">
                                <span class="input-group-addon">(021)</span>
                                <input id="nomertelepon" name="prependedtext" class="form-control" placeholder="Nomer Telepon" type="number">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="singlebutton"></label>
                        <div class="col-md-4">
                            <button id="simpan" type="button" name="simpan" class="btn btn-primary">Simpan</button>
                        </div>
                    </div>

                </fieldset>
            </form>
            
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>Nama</th>
                        <th>Email</th>
                        <th>Nomer Telepon</th>
                    </tr>
                </thead>
                <tbody id="isiTable">
                </tbody>
            </table>
        </div>
        <!-- End of Container -->
        
        <!-- Footer -->
        <jsp:include page="inc/footer.jsp" />
        <!-- End of Footer -->
        
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script>
            
            // hide label sukses
            $('#suksesdiv').hide();
            
            // hide label gagal
            $('#gagaldiv').hide();
            
            // ambil isi table
            getContent();
            
            // jika tombol simpan di-klik
            $('#simpan').click(function () {
                $.ajax({
                    type: "POST", // method POST
                    url: 'RegistrasiServlet', // nama servlet kita
                    data: { nama : $('#nama').val(), email : $('#email').val(), nomertelepon : $('#nomertelepon').val() }
                })
                .done(function(data) {
                    if(data.status === 1) {
                        // jika berhasil maka tampilkan label sukses
                        $('#suksesdiv').show();
                        
                        // lalu di reset
                        $('#form1')[0].reset();
                    } else {
                        // jika gagal maka tampilkan label gagal
                        $('#gagaldiv').show();
                    } 
                    
                    // berhasil atau gagal, load isi table
                    getContent(); 
                });  
            });
            
            // fungsi untuk mengambil isi table
            function getContent() {
                $.ajax({
                    type: "GET", // method GET
                    url: 'RegistrasiServlet' // nama servlet kita
                })
                .done(function(data) {
                    // clear table
                    $('#isiTable').html("");
                    
                    // isi table
                    $.each(data, function(key, value) {
                        $('#isiTable').append('<tr><td>'+value.nama+'</td><td>'+value.email+'</td><td>'+value.nomerTelepon+'</td></tr>');
                    });
                });  
            }
        </script>
    </body>
</html>
