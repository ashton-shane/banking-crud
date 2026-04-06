import "./styles/App.css";
import Header from "./components/Header";
import Sidebar from "./components/Sidebar";

import { Routes, Route } from "react-router-dom";
import FindAccount from "./pages/FindAccount";
import FindCustomer from "./pages/FindCustomer";
import DisplayAccounts from "./pages/DisplayAccounts";
import DisplayCustomers from "./pages/DisplayCustomers";

function App() {
  return (
    <div className="app">
      <Header />

      <div className="app-body">
        <Sidebar />
        <Routes>
            <Route path="/find-customer" element={<FindCustomer />}></Route>
            <Route path="/find-account" element={<FindAccount />}></Route>
            <Route path= "/accounts" element={<DisplayAccounts />}></Route>
            <Route path= "/customers" element={<DisplayCustomers />}></Route>
        </Routes>
      </div>
    </div>
  );
}

export default App;
