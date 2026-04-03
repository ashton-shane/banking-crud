import { Link } from "react-router-dom";
import SearchBar from "./SearchBar";

function Sidebar() {
  return (
    <aside className="sidebar" aria-label="Main navigation">
      <SearchBar />

      <nav className="sidebar-nav">
        <Link to="/">Home</Link>
        <Link to="/add">Add</Link>
        <Link to="/update">Update</Link>
        <Link to="/users">Users</Link>
        <Link to="/find-by-id">Find by Id</Link>
        <Link to="/find-by-balance">Find by Balance</Link>
      </nav>

      <div className="sidebar-footer">
        <Link to="/login">Login</Link>
        <Link to="/register">Register</Link>
      </div>
    </aside>
  );
}

export default Sidebar;
