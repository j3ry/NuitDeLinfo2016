<!DOCTYPE html>
<html lang="en">
<head>
  <title>Gigabits</title>
  <?php include 'head.php' ?>
  <script type="text/javascript" src="fonctions.js"></script>
<div id="fond">
<div class="jumbotron text-center">
  <form class="form-inline">
    <h2 class="space">Jeanne Au secours!</h2>
    <p>_________________________________________________________________</p>
  </form>
  <div id="pub">
    <a href="http://www.msf.fr"><img src="./images/MSFPUB.jpg" alt="pub"></a>
    <button onclick="removeAds()" class="button">
      <img src="./images/button.png" alt="" class="button">
    </button>    
  </div>
</div>
</div>

<!-- Container (About Section) -->
<div id="regle" class="container-fluid">
  <div class="row slideanim">
    <div class="col-sm-8">
      <h2>Règles du jeu</h2><br>
      <h4>But du jeu :</h4><br>
      <p>Comment ça marche...</p>
      <br>
    </div>
  </div>
</div>

<!-- Container (Services Section) -->
<div id="jeu" class="container-fluid text-center bg-grey">
  <!-- <h2>TD</h2>
  <h4>Découvrez mes TD</h4>
  <br>

  <div class="row slideanim">

    <div class="col-sm-4">
      <h4><a href="TD1.php" title="To TD1"> TD1 </a></h4>
    </div>

    <div class="col-sm-4">
      <h4><a href="TD2.php" title="To TD2"> TD2 </a></h4>
    </div>

    <div class="col-sm-4">
      <h4><a href="TD3.php" title="To TD3"> TD3 </a></h4>
    </div>
  </div> -->


  <br><br>
  <div class="row slideanim">
    <div class="col-sm-6">
    </div>

    <div class="col-sm-6">
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <h1> Nuit de l'info </h1>
  <p> Site créé par <br>
  © 2016 - Gigabits </p>

</footer>

<script>
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Prevent default anchor click behavior
    event.preventDefault();

    // Store hash
    var hash = this.hash;

    // Using jQuery's animate() method to add smooth page scroll
    // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
    $('html, body').animate({
      scrollTop: $(hash).offset().top
    }, 900, function(){

      // Add hash (#) to URL when done scrolling (default click behavior)
      window.location.hash = hash;
    });
  });

  // Slide in elements on scroll
  $(window).scroll(function() {
    $(".slideanim").each(function(){
      var pos = $(this).offset().top;

      var winTop = $(window).scrollTop();
        if (pos < winTop + 600) {
          $(this).addClass("slide");
        }
    });
  });
})
</script>

</body>
</html>
