import { Provider } from "react-redux";
import { BrowserRouter } from "react-router-dom";
import store from "../store/store";
import Main from "./Main";
import OnAnonymous from "./OnAnonymous";
import OnAuthenticated from "./OnAuthenticated";

const App = () => (
  <Provider store={store}>
    <BrowserRouter>
      <OnAnonymous />
      <OnAuthenticated>
        <Main />
      </OnAuthenticated>
    </BrowserRouter>
  </Provider>
);

export default App;
