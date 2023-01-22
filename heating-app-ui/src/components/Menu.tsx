import { Link } from "react-router-dom"
import UserService from "../services/UserService"

const Menu = () => (
  <nav className="navbar navbar-expand navbar-light bg-light px-2">
    <a className="navbar-brand">Inteligent Heating</a>

    <div className="d-flex align-items-center w-100">
      <ul className="navbar-nav">
        <li className="nav-item active">
          <Link className="nav-link" to="/">
            Home
          </Link>
        </li>
      </ul>

      <div className="ms-auto">Hi, {UserService.getUsername()}!</div>
      <button className="btn btn-outline-dark mx-2" onClick={() => UserService.logout()}>Logout</button>

    </div>
  </nav>
)

export default Menu