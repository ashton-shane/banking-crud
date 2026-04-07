import { Link } from "react-router-dom";
function Sidebar() {
  return (
    <aside className="sidebar" aria-label="Main navigation">
      <nav className="sidebar-nav">
        <Link to="/">Home</Link>
        <Link to="/customers">Customers</Link>
        <Link to="/accounts">Accounts</Link>
      </nav>
    </aside>
  );
}

export default Sidebar;
