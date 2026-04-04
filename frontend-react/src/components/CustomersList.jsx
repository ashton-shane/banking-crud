function CustomersList({ customers }) {
  return (
    <main className="main">
      <h2>View All Customers</h2>

      <div className="toolbar">
        <button type="button" className="btn btn-primary">
          Add New Customer
        </button>
      </div>

      <div className="table-card">
        <table className="accounts-table">
          <thead>
            <tr>
              <th scope="col">Customer Id</th>
              <th scope="col">Customer Name</th>
              <th scope="col">Account Id</th>
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
                <td className="mono">{row.account_id}</td>
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

