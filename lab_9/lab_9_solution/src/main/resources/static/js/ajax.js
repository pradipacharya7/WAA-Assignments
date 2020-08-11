


     function makeAjaxCall() {


         //   var firstname=$('#firstname').val();
         //   var lastname=$('#lastname').val();
         //   var email=$('#email').val();
         // // var data=JSON.stringify($('#employeeForm').serializeFromJSON());
         //
         // var data = {
         //     firstName: firstname,
         //     lastName: lastname,
         //     email: email
         // }


         $.ajax({
             url:"/rest/addEmployee",
             contentType: "application/json",
             type:"POST",
             data:JSON.stringify( serializeObject($('#employeeForm'))),
             dataType: "json",
             success: function (data) {
                 resetForm('employeeForm');
                 $('#formInput').html("");
                 $("#formInput").append('<H3 align="center"> New Employee Information <H3>');
                 $('#formInput').append(`<H4 align='center'>First Name:  ${data.firstName} </h4>`);
                 $('#formInput').append(`<H4 align='center'>Last Name: ${data.lastName} </h4>`);
                 $('#formInput').append(`<H4 align='center'>Email: ${data.email} </h4>`);
                 $("#formInput").append('<h4 align="center"> <a href="#" onclick="toggle_visibility(\'formInput\');resetForm(\'employeeForm\');"><b>EXIT</b> </a> </h4>');
                 make_visible('formInput');
                 make_hidden('errors');
             },

             error: function (XMLHttpRequest) {

                    $('#errors').text('');

                     if (XMLHttpRequest.responseJSON.errorType == "ValidationError") {
                         var errorList = XMLHttpRequest.responseJSON.errors;
                         console.log(errorList);
                         $("#errors").append(`<h3>***Errors***</h3>`);
                         for(var error in errorList)
                         {
                             $("#errors").append(`<p>${errorList[error].message}</p>`);

                         }

                         make_visible('errors');

                     } else {
                         alert(errorObject.responseJSON.errors(0)); // "non" Validation
                     }


             }

         });
     }

     toggle_visibility = function (id) {
         var element = document.getElementById(id);
         if (element.style.display == 'block')
             element.style.display = 'none';
         else
             element.style.display = 'block';
     }

     make_hidden = function (id) {
         var element = document.getElementById(id);
         element.style.display = 'none';
     }

     make_visible = function (id) {
         var element = document.getElementById(id);
         element.style.display = 'block';
     }

     resetForm = function (id) {
         var element = document.getElementById(id);
         $(element)[0].reset();

     }

// Translate form to array
// Then put in JSON format
     function serializeObject(form) {
         var jsonObject = {};
         var array = form.serializeArray();
         $.each(array, function () {
             jsonObject[this.name] = this.value;
         });
         return jsonObject;

     };


