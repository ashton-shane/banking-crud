import { Link } from "react-router-dom";
import SearchBar from "./SearchBar";

function Sidebar() {
  return (
    <aside className="sidebar" aria-label="Main navigation">
      <SearchBar />

      <nav className="sidebar-nav">
        <Link to="/">Home</Link>
        <Link to="/customers">Customers</Link>
        <Link to="/accounts">Accounts</Link>
      </nav>
    </aside>
  );
}

export default Sidebar;
