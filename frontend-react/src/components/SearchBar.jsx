import "../styles/inline.css";
import { useState } from "react";

function SearchBar({ compact = false, onSearch = () => {} }) {
  const [value, setValue] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    onSearch(value);
  };

  return (
    <form className="sidebar-search" role="search" onSubmit={handleSubmit}>
      <input
        type="search"
        value={value}
        onChange={(e) => setValue(e.target.value)}
        placeholder="Search..."
        aria-label="Search"
      />
      <button type="submit" title="Search" aria-label="Search">
        <span className="search-icon" aria-hidden="true" />
      </button>
    </form>
  );
}

export default SearchBar;
