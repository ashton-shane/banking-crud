import "./styles/App.css";
import Header from "./components/Header";
import Sidebar from "./components/Sidebar";

import { Routes, Route} from "react-router-dom";
import DisplayAccounts from "./pages/DisplayAccounts";
import DisplayCustomers from "./pages/DisplayCustomers";
import Homepage from "./pages/Homepage";


function App() {
  return (
    <div className="app">
      <Header />

      <div className="app-body">
        <Sidebar />
        <Routes>
            <Route path="/accounts" element={<DisplayAccounts />}></Route>
            <Route path="/customers" element={<DisplayCustomers />}></Route>
            <Route path="/" element={<Homepage />}></Route>
        </Routes>
      </div>
    </div>
  );
}

export default App;
