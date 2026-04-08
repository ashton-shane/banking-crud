import SearchBar from "./SearchBar";

function CustomersList({ customers }) {
  return (
    <main className="main">
      <h2>View All Customers</h2>

      <div className="toolbar">
        <div className="toolbar-left">
          <button type="button" className="btn btn-primary">
            Add New Customer
          </button>
          <div className="toolbar-search">
            <SearchBar compact />
          </div>
        </div>
      </div>

      <div className="table-card">
        <table className="accounts-table">
          <thead>
            <tr>
              <th scope="col">Customer Id</th>
              <th scope="col">Customer Name</th>
              <th scope="col">Account Ids</th>
              <th scope="col" className="col-actions">
                Actions
              </th>
            </tr>
          </thead>
          <tbody>
            {customers.map((row) => (
              <tr key={row.id}>
                <td className="mono">{row.id}</td>
                <td className="mono">{row.name}</td>
                <td className="mono">{row.accountIds.join(", ")}</td>
                <td className="col-actions">
                  <div className="actions-cell">
                    <button type="button" className="btn btn-edit">
                      Update
                    </button>
                    <button type="button" className="btn btn-danger">
                      Delete
                    </button>
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </main>
  );
}

export default CustomersList;

