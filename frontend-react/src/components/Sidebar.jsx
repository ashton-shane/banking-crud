import { Link } from "react-router-dom";
import SearchBar from "./SearchBar";

function Sidebar() {
  return (
    <aside className="sidebar" aria-label="Main navigation">
      <SearchBar />

      <nav className="sidebar-nav">
        <Link to="/">Home</Link>
        <Link to="/create-customer">Create Corporate Customer</Link>
        <Link to="/customers">Customers</Link>
        <Link to="/find-customer">Find Customer</Link>
        <Link to="/create-customer">Create Account</Link>
        <Link to="/accounts">Accounts</Link>
        <Link to="/find-account">Find Account</Link>
      </nav>
    </aside>
  );
}

export default Sidebar;
