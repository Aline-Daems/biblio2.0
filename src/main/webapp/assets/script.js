// function changeBackground(){
//     const colors = ['#ff0000', '#00ff00', '#0000ff', '#ffff00']; // Liste de couleurs
//     const colorsText = ['#40E0D0', '#FFA500', '#800080', '#00FFFF']
//     const randomColor = colors[Math.floor(Math.random() * colors.length)]; // Couleur aléatoire
//     const colorsTextRandom = colorsText[Math.floor(Math.random() * colorsText.length)]; // Couleur aléatoire
//      body =   document.getElementById("body");
//      congrats = document.getElementById("congrats");
//
//     body.style.backgroundColor = randomColor;
//     congrats.style.color = colorsTextRandom;
//
//     setTimeout(changeBackground, 3000);
// }
//
// changeBackground();
//
// function randomPosition() {
//     const paragraph = document.getElementById('congrats');
//     const maxX = window.innerWidth - paragraph.clientWidth; // Largeur maximale de l'écran
//     const maxY = window.innerHeight - paragraph.clientHeight; // Hauteur maximale de l'écran
//
//     // Générer des coordonnées aléatoires pour le déplacement
//     const randomX = Math.random() * maxX;
//     const randomY = Math.random() * maxY;
//
//     // Appliquer les nouvelles coordonnées
//     paragraph.style.position = 'absolute';
//     paragraph.style.left = randomX + 'px';
//     paragraph.style.top = randomY + 'px';
// }
//
// // Appeler la fonction pour déplacer la balise <p> initialement et à intervalles réguliers
// randomPosition();
// setInterval(randomPosition, 3000); // Changez toutes les 3 secondes


window.onload = function () {
    const text = document.getElementById("title");
    const text2 = document.getElementById("title2");

    // Ajouter une classe CSS pour activer l'effet de fondu
    text.classList.add("fade-in");
    text2.classList.add("fade-in");
};