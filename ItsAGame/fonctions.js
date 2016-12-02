function removeAds() {
  document.getElementById("pub").remove()
}

window.onload = function() {
	window.setInterval(function() {

		if (!document.getElementById("autoGenerateAd")) {
			var container = document.createElement("div"),
				imageButton = document.createElement("img"),
				linkPub = document.createElement("a"),
				imagePub = document.createElement("img");

			container.id = "autoGenerateAd";
			imageButton.className = "button";
			imageButton.src = "./images/button.png";
			imagePub.src = "./images/pub.jpg";
			linkPub.href = "http://www.msf.fr";

			imageButton.onclick = function() {
				document.getElementById("autoGenerateAd").remove();
			}

			linkPub.appendChild(imagePub);
			container.appendChild(linkPub);
			container.appendChild(imageButton);
			document.body.appendChild(container);
		}
	}, 60000);
}