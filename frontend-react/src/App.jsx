import "./styles/App.css";
import Form from "./components/Form";
import Header from "./components/Header";
import Sidebar from "./components/Sidebar";

import { Routes, Route} from "react-router-dom";
import FindById from "./components/FindById";
import FindAccount from "./pages/FindAccount";
import FindCustomer from "./pages/FindCustomer";

function App() {
  return (
    <div className="app">
      <Header />

      <div className="app-body">
        <Sidebar />
        <Routes>
            <Route path="/find-customer" element={<FindCustomer />}></Route>
            <Route path="/find-account" element={<FindAccount />}></Route>
        </Routes>
        <Form />
      </div>
    </div>
  );
}

export default App;
