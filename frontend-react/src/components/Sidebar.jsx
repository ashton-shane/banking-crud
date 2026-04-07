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
        <Link to="/create-customer">Create Account</Link>
        <Link to="/accounts">Accounts</Link>
        {/* Note: find-by-id routes removed from sidebar per request; use display pages' top-of-table find input */}
      </nav>
    </aside>
  );
}

export default Sidebar;
