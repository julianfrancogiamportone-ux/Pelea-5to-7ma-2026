document.addEventListener("DOMContentLoaded", () => {
    const rosterContainer = document.getElementById("roster");
    const p1Img = document.querySelector(".p1-portrait");
    const p1Name = document.querySelectorAll(".character-name")[0]; 
    const p2Img = document.querySelector(".p2-portrait");
    const p2Name = document.querySelectorAll(".character-name")[1];
    
    // Capturamos el div de resultado que pide el profesor
    const resultDiv = document.getElementById("result");
    const fightButton = document.getElementById("fightButton");
    
    let turno = 1; 
    let peleadorP1 = null;
    let peleadorP2 = null;

    // Conectamos a tu API
    fetch('http://localhost:8080/peleadores')
        .then(response => response.json())
        .then(peleadores => {
            peleadores.forEach(peleador => {
                const img = document.createElement("img");
                
                // Si falla la imagen, pone una por defecto
                img.src = peleador.url_imagen ? peleador.url_imagen : "images/placeholder.png";
                img.alt = peleador.nombre;
                img.className = "roster-slot";
                img.title = peleador.nombre; 

                // Lógica para elegir personajes (tu diseño arcade)
                img.addEventListener("click", () => {
                    if (turno === 1) {
                        p1Img.src = img.src; 
                        p1Name.textContent = peleador.nombre; 
                        p1Img.style.borderColor = "#3498db"; 
                        peleadorP1 = peleador; 
                        turno = 2; 
                    } else {
                        p2Img.src = img.src;
                        p2Name.textContent = peleador.nombre;
                        p2Img.style.borderColor = "#e74c3c"; 
                        peleadorP2 = peleador; 
                        turno = 1; 
                    }
                });

                rosterContainer.appendChild(img);
            });
        })
        .catch(error => console.error("Error conectando con la API:", error));

    // Lógica de Batalla
    fightButton.addEventListener("click", () => {
        if (!peleadorP1 || !peleadorP2) {
            alert("¡Ambos jugadores deben seleccionar un luchador primero!");
            return; 
        }

        // Calculamos el poder usando las variables exactas de tu Base de Datos
        let poderP1 = peleadorP1.puntosdevida + (peleadorP1.energia * peleadorP1.bonificadordanio) + peleadorP1.defensabase;
        let poderP2 = peleadorP2.puntosdevida + (peleadorP2.energia * peleadorP2.bonificadordanio) + peleadorP2.defensabase;

        let mensaje;

        // Comparamos quién gana
        if (poderP1 > poderP2) {
            mensaje = `¡${peleadorP1.nombre} GANA LA BATALLA!`;
        } else if (poderP2 > poderP1) {
            mensaje = `¡${peleadorP2.nombre} GANA LA BATALLA!`;
        } else {
            mensaje = "¡LA BATALLA TERMINA EN EMPATE!";
        }

        // Mostramos el resultado en pantalla como sugiere el material
        resultDiv.textContent = mensaje;
        resultDiv.classList.remove('hidden');
    });
});