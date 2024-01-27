loadAllVehicles();

function loadAllVehicles() {

    function loadHotelData() {
        $.ajax({
            url: 'http://localhost:8080/Mapping/api/vehicle', // Replace with your actual backend URL
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                if (data.code === '200') {
                    var vehicles = data.data;
                    var vehiclelList = $('#card-container');

                    // Iterate through the hotel data and create card elements
                    for (var i = 0; i < vehicles.length; i++) {
                        var vehicle = vehicles[i];
                        var card = `<div class="row">
                                      <div class="col-md-4">
                                      <div class="row">
                                        <div class="col-md-6">
                                             <img src="" alt="" class="img-thumbnail guide-image" >
                                        </div>
                                         <div class="col-md-6">
                                            <img src="" alt="" class="img-thumbnail nic-image" >
                                         </div>
                                      </div>
                                      </div>
                                      <div class="col-md-8">
                                          <div class="container text-center details-wrapper">
                                              <div class="details-col">
                                               <div class="details lblid" >
                                                      <div class=""> <small>Id :</small> </div>
                                                      <div> `+vehicle.id+` </div>
                                                  </div>
                                                  
                                                   <div class="details">
                                                      <div> <small style="color:deepskyblue;">Driver Name :</small> </div>
                                                      <div>`+vehicle.driver_name+`</div>
                                                  </div>
                                                  
                                                   <div class="details">
                                                      <div> <small style="color:deepskyblue;">Driver Contact NO :</small> </div>
                                                      <div>`+vehicle.driver_contact+`</div>
                                                  </div>
                                                  
                                                  <div class="details">
                                                      <div> <small style="color:deepskyblue;">Vehicle Brand :</small> </div>
                                                      <div>`+vehicle.vehicle_brand+`</div>
                                                  </div>
                          
                                                  <div class="details">
                                                      <div> <small style="color:deepskyblue;">Vehicle Category :</small> </div>
                                                      <div>`+vehicle.vehicle_category+`</div>
                                                  </div>
                                              </div>
                                              <div style="padding-left: 20px;">                                           
                                                  <div class="details">
                                                      <div> <small style="color:deepskyblue;">Fuel Type :</small> </div>
                                                      <div> `+vehicle.fuel_type+` </div>
                                                  </div>
                                                  <div class="details">
                                                      <div> <small style="color:deepskyblue;">Hybrid Or Non Hybrid :</small> </div>
                                                      <div>`+vehicle.hybrid_OR_nonHybrid+`</div>
                                                  </div>
                          
                                                  <div class="details">
                                                      <div> <small style="color:deepskyblue;">Fuel Usage :</small> </div>
                                                      <div>`+vehicle.fuel_usage+`</div>
                                                  </div>
                                                   <div class="details">
                                                      <div> <small style="color:deepskyblue;">Seat Capacity :</small> </div>
                                                      <div>`+vehicle.seatCapacity+`</div>
                                                  </div>
                                                   <div class="details">
                                                      <div> <small style="color:deepskyblue;">Vehicle Type :</small> </div>
                                                      <div>`+vehicle.vehicle_type+`</div>
                                                  </div>
                                                  
                                                  
                                              </div>
                                              <div style="padding-left: 20px;" class="next-button">
                                              <button type="button" class="btn btn-primary ">Choose Package >></button> 
                                              </div>

                                          </div>
                                      </div>
                     </div>
                        `;



                        vehiclelList.append(card);
                       // #card-container > div:nth-child(2) > div.col-md-4 > div > div:nth-child(1) > img
                        $("#card-container .row:last-child div div:nth-child(1) > img").attr('src', `data:image/png;base64,`+vehicle.vehicle_img+``);
                        $("#card-container .row:last-child div div:nth-child(2) > img").attr('src', `data:image/png;base64,`+vehicle.driver_license_image+``);
                    }
                } else {
                    // Handle the error case here
                    console.log('Error: ' + data.message);
                }
            },
            error: function (error) {
                // Handle the error case here
                console.log('Error: ' + error);
            }
        });
    }

    // Call the function to load hotel data
    loadHotelData();



}

