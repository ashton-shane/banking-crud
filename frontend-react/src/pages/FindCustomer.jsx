import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

const FindCustomer = () => {
  const { id } = useParams();
  const [custRow, setCustRow] = useState({
    id: "-",
    name: "-",
    accountIds: ["-"],
  });

  useEffect(() => {
    axios
      .get(`/api/customers/${id}`)
      .then((res) => {
        console.log(res);
        setCustRow(res.data);
      })
      .catch((error) => "Error: " + error);
  }, [id]);

  return (
    <main className="main">
      <h2>Customer</h2>
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
            <tr key={custRow.id}>
              <td className="mono">{custRow.id}</td>
              <td className="mono">{custRow.name}</td>
              <td className="mono">{custRow.accountIds.join(", ")}</td>
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
          </tbody>
        </table>
      </div>
    </main>
  );
};

export default FindCustomer;
