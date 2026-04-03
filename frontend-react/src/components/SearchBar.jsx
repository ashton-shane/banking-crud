function SearchBar() {
  return (
    <form className="sidebar-search" role="search" onSubmit={(e) => e.preventDefault()}>
      <input type="search" placeholder="Search..." aria-label="Search" />
      <button type="submit" title="Search" aria-label="Search">
        <svg
          width="18"
          height="18"
          viewBox="0 0 24 24"
          fill="none"
          stroke="currentColor"
          strokeWidth="2.2"
          strokeLinecap="round"
          strokeLinejoin="round"
          aria-hidden
        >
          <circle cx="11" cy="11" r="7" />
          <path d="m21 21-4.3-4.3" />
        </svg>
      </button>
    </form>
  );
}

export default SearchBar;
