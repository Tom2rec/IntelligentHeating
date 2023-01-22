import ReactDOM from "react-dom";
import HttpService from "./services/HttpService";
import UserService from "./services/UserService";
import App from "./components/App";
import "bootstrap/dist/js/bootstrap.min.js";
import "bootstrap/dist/css/bootstrap.min.css";
import "leaflet/dist/leaflet.css";

const renderApp = () => ReactDOM.render(<App />, document.getElementById("app"));

UserService.initKeycloak(renderApp);
HttpService.configure();