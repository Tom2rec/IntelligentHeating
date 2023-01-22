import UserService from "../services/UserService";

const OnAnonymous = () => {
    if (!UserService.isLoggedIn()) {
        UserService.login()
    }

    return (<></>)
}

export default OnAnonymous
