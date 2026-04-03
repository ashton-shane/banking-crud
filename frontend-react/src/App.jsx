import "./App.css";
import Form from "./components/AccountsList";
import Header from "./components/Header";
import Sidebar from "./components/Sidebar";

const SAMPLE_ACCOUNTS = [
  { id: 1, balance: 5000.0, interestRate: 1 },
  { id: 2, balance: 10000.0, interestRate: 2 },
  { id: 3, balance: 15000.0, interestRate: 1 },
  { id: 4, balance: 20000.0, interestRate: 2 },
  { id: 5, balance: 25000.0, interestRate: 1 },
  { id: 6, balance: 30000.0, interestRate: 2 },
  { id: 7, balance: 35000.0, interestRate: 1 },
  { id: 8, balance: 40000.0, interestRate: 2 },
];

function App() {
  return (
    <div className="app">
      <Header />

      <div className="app-body">
        <Sidebar />
        <Form accounts={SAMPLE_ACCOUNTS} />
      </div>
    </div>
  );
}

export default App;
