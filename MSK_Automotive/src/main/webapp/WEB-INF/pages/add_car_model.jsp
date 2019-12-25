<html lang="en"><head>
  <meta charset="utf-8">
  <title>Bike</title>
  <base href="/">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">/* You can add global styles to this file, and also import other style files */
</style></head>
<body cz-shortcut-listen="true">
  <app-root _nghost-c0="" ng-version="5.1.3">




<router-outlet _ngcontent-c0=""></router-outlet><app-dashboard _nghost-c1="">
<app-header _ngcontent-c1="" _nghost-c2=""><nav _ngcontent-c2="" class="navbar navbar-inverse">
  <div _ngcontent-c2="" class="container-fluid">
    <div _ngcontent-c2="" class="navbar-header">
      <a _ngcontent-c2="" class="navbar-brand" href="#">Bike WebSiteName</a>
    </div>
    <ul _ngcontent-c2="" class="nav navbar-nav">
      <li _ngcontent-c2=""><a _ngcontent-c2="">Home</a></li>    
      <li _ngcontent-c2=""><a _ngcontent-c2="">Add Bike</a></li>
    </ul>
    <button _ngcontent-c2="" class="btn btn-danger navbar-btn" style="float:right"><a _ngcontent-c2="" href="#" style="color:#ffff">Logout</a></button>
  </div>
</nav></app-header>


<!--bindings={
  "ng-reflect-ng-if": "false"
}-->


<!--bindings={
  "ng-reflect-ng-if": "true"
}--><app-add _ngcontent-c1="" _nghost-c4="">
<div _ngcontent-c4="" class="container">
  
  <div _ngcontent-c4="" class="col-lg-2">

  </div>
  <div _ngcontent-c4="" class="col-lg-8">
  <h2 _ngcontent-c4="">Add Bike</h2>
 
    <div _ngcontent-c4="" class="form-group row">
      <label _ngcontent-c4="" class="control-label col-sm-2" for="email">Bike Name:</label>
      <div _ngcontent-c4="" class="col-sm-10">
        <input _ngcontent-c4="" class="form-control" id="email" name="name" placeholder="Enter bike name" required="" type="text">
      </div>
    </div>

    <div _ngcontent-c4="" class="form-group row">
        <label _ngcontent-c4="" class="col-sm-2" for="sel1">Select list:</label>
        <div _ngcontent-c4="" class="col-sm-10"> 

        <select _ngcontent-c4="" class="form-control" id="sel1" required="">
          <option _ngcontent-c4="">Select Bike CC </option>
          <!--bindings={
  "ng-reflect-ng-for-of": "below 100cc,150cc,200cc"
}--><option _ngcontent-c4="" value="below 100cc">below 100cc</option><option _ngcontent-c4="" value="150cc">150cc</option><option _ngcontent-c4="" value="200cc">200cc</option>

        </select>

        </div>
      </div>

      <div _ngcontent-c4="" class="form-group row">
          <label _ngcontent-c4="" class="control-label col-sm-2" for="email">Bike Image URL:</label>
          <div _ngcontent-c4="" class="col-sm-10">
            <input _ngcontent-c4="" class="form-control" id="email" name="name" placeholder="Enter bike name" required="" type="text">
          </div>
        </div>

        <div _ngcontent-c4="" class="form-group row">
          <label _ngcontent-c4="" class="col-sm-2" for="comment">Description:</label>
          <div _ngcontent-c4="" class="col-sm-10">
          <textarea _ngcontent-c4="" class="form-control" id="comment" required="" rows="5"></textarea>
        </div>
        </div>

     <div _ngcontent-c4="" class="form-group row">        
      <div _ngcontent-c4="" class="col-sm-offset-2 col-sm-10">
        <button _ngcontent-c4="" class="btn btn-default" type="buttton">Submit</button>
      </div>
    </div>
  
  </div>

  <div _ngcontent-c4="" class="col-lg-2">

  </div></div></app-add>




<!--bindings={
  "ng-reflect-ng-if": "false"
}-->

</app-dashboard>




</app-root>
<script type="text/javascript" src="inline.bundle.js"></script><script type="text/javascript" src="polyfills.bundle.js"></script><script type="text/javascript" src="styles.bundle.js"></script><script type="text/javascript" src="vendor.bundle.js"></script><script type="text/javascript" src="main.bundle.js"></script>

</body></html>