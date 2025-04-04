// Firebase Config (replace with your actual config)
import { initializeApp } from "https://www.gstatic.com/firebasejs/10.7.1/firebase-app.js";
import { getDatabase, ref, onChildAdded } from "https://www.gstatic.com/firebasejs/10.7.1/firebase-database.js";

const firebaseConfig = {
    apiKey: "AIzaSyDqv3O6gNzkZ-zv9vQ2hUwvwOYWwW6aM9k",
    authDomain: "demo-lostlink.firebaseapp.com",
    databaseURL: "https://demo-lostlink-default-rtdb.firebaseio.com",
    projectId: "demo-lostlink",
    storageBucket: "demo-lostlink.appspot.com",
    messagingSenderId: "1234567890",
    appId: "1:1234567890:web:abcdefg123456"
  };

const app = initializeApp(firebaseConfig);
const db = getDatabase(app);

const alertsRef = ref(db, "alerts");
const alertsContainer = document.getElementById("alerts");

// Real-time listener
onChildAdded(alertsRef, (data) => {
  const alert = data.val();
  const alertCard = `
    <div class="col-md-4">
      <div class="card">
        <h5>${alert.name}</h5>
        <p><strong>Last Seen:</strong> ${alert.lastSeen}</p>
        <p><strong>Location:</strong> ${alert.location}</p>
        <p><strong>Time:</strong> ${new Date(alert.timestamp).toLocaleString()}</p>
      </div>
    </div>
  `;
  alertsContainer.innerHTML = alertCard + alertsContainer.innerHTML;
});

