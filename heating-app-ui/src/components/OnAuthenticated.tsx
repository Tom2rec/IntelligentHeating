import UserService from "../services/UserService";

const OnAuthenticated = ({ children }) => (UserService.isLoggedIn()) ? children : null;

export default OnAuthenticated
