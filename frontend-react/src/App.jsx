import "./styles/App.css";
import Form from "./components/Form";
import Header from "./components/Header";
import Sidebar from "./components/Sidebar";

function App() {
  return (
    <div className="app">
      <Header />

      <div className="app-body">
        <Sidebar />
        <Form />
      </div>
    </div>
  );
}

export default App;
