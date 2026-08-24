document.addEventListener("DOMContentLoaded", () => {
    // 1. Definimos ambas APIs (Ajusta los puertos si es necesario)
    const API_MIA = 'http://localhost:8080/peleadores'; // Tu API
    const API_AMIGO = 'http://localhost:8081/api/characters'; // La API de tu amigo

    const rosterContainer = document.getElementById("roster");
    const p1Img = document.querySelector(".p1-portrait");
    const p1Name = document.querySelectorAll(".character-name")[0]; 
    const p2Img = document.querySelector(".p2-portrait");
    const p2Name = document.querySelectorAll(".character-name")[1];
    const resultDiv = document.getElementById("result");
    const fightButton = document.getElementById("fightButton");
    
    let turno = 1; 
    let peleadorP1 = null;
    let peleadorP2 = null;
    let todosLosPeleadores = [];

    // 2. Función adaptadora (Como la normalizarPersonajeCompanero de tu amigo)
    function adaptarPersonajeAmigo(personaje) {
        return {
            nombre: personaje.nombre,
            // Adaptamos las variables del amigo a tus fórmulas
            puntosdevida: personaje.puntosVida || 100, 
            energia: personaje.energia || 50,
            defensabase: personaje.defensaBase || 10,
            bonificadordanio: 1, // Si tu amigo no tiene esta variable, le damos 1 por defecto
            // Le agregamos la ruta de su servidor a sus imágenes para que no se rompan
            url_imagen: personaje.url_imagen ? `http://localhost:8081/${personaje.url_imagen}` : "images/placeholder.png"
        };
    }

    // 3. Función asíncrona para traer ambas bases de datos
    async function cargarTodosLosLuchadores() {
        let misPeleadores = [];
        let peleadoresAmigo = [];

        // Traemos tus personajes
        try {
            const respuestaMia = await fetch(API_MIA);
            misPeleadores = await respuestaMia.json();
        } catch (error) {
            console.error("Error cargando mi API:", error);
        }

        // Traemos los personajes de tu amigo
        try {
            const respuestaAmigo = await fetch(API_AMIGO);
            const dataAmigo = await respuestaAmigo.json();
            // Pasamos los personajes del amigo por el "traductor"
            peleadoresAmigo = dataAmigo.map(adaptarPersonajeAmigo);
        } catch (error) {
            console.error("Error cargando la API del amigo:", error);
        }

        // 4. Juntamos ambos arrays (Igual que hizo tu amigo con [...propios, ...delProfe])
        todosLosPeleadores = [...misPeleadores, ...peleadoresAmigo];
        renderizarRoster();
    }

    // 5. Dibujamos los personajes en la pantalla
    function renderizarRoster() {
        todosLosPeleadores.forEach(peleador => {
            const img = document.createElement("img");
            img.src = peleador.url_imagen ? peleador.url_imagen : "images/placeholder.png";
            img.alt = peleador.nombre;
            img.className = "roster-slot";
            img.title = peleador.nombre; 

            // Lógica para elegir personajes 
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
    }

    // 6. Lógica de Batalla Arcade (Se mantiene idéntica)
    fightButton.addEventListener("click", () => {
        if (!peleadorP1 || !peleadorP2) {
            alert("¡Ambos jugadores deben seleccionar un luchador primero!");
            return; 
        }

        let poderP1 = peleadorP1.puntosdevida + (peleadorP1.energia * peleadorP1.bonificadordanio) + peleadorP1.defensabase;
        let poderP2 = peleadorP2.puntosdevida + (peleadorP2.energia * peleadorP2.bonificadordanio) + peleadorP2.defensabase;

        let mensaje;

        if (poderP1 > poderP2) {
            mensaje = `¡${peleadorP1.nombre} GANA LA BATALLA!`;
        } else if (poderP2 > poderP1) {
            mensaje = `¡${peleadorP2.nombre} GANA LA BATALLA!`;
        } else {
            mensaje = "¡LA BATALLA TERMINA EN EMPATE!";
        }

        resultDiv.textContent = mensaje;
        resultDiv.classList.remove('hidden');
    });

    // 7. Arrancamos el programa
    cargarTodosLosLuchadores();
});