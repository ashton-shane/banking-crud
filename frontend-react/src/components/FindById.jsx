import { useState } from "react";

export default function FindById({ id: initialId, onFind }) {
  const [value, setValue] = useState(initialId ?? "");
  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (value === "" || value === null || typeof value === "undefined") {
      setResult({ error: "Please enter an id" });
      return;
    }

    if (onFind) {
      try {
        setLoading(true);
        const res = await onFind(value);
        setResult(res);
      } catch (err) {
        setResult({ error: err?.message ?? String(err) });
      } finally {
        setLoading(false);
      }
    } else {
      // No backend provided — show a simple local result for now
      setResult({ id: value, message: "No backend connected — sample result." });
    }
  };

  return (
    <div>
      <form className="sidebar-search" role="search" onSubmit={handleSubmit}>
        <input
          type="number"
          placeholder="Enter id"
          aria-label="Find by id"
          value={value}
          onChange={(e) => setValue(e.target.value)}
        />
        <button type="submit" title="Find" aria-label="Find">
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

      <div style={{ marginTop: "1rem" }}>
        {loading && <div className="table-card" style={{ padding: "1rem" }}>Loading...</div>}
        {!loading && result && (
          <div className="table-card" style={{ padding: "1rem" }}>
            {result.error ? (
              <div style={{ color: "#b91c1c", fontWeight: 600 }}>{result.error}</div>
            ) : (
              <pre style={{ margin: 0 }}>{JSON.stringify(result, null, 2)}</pre>
            )}
          </div>
        )}
      </div>
    </div>
  );
}

