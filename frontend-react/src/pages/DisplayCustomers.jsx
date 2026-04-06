import CustomersList from "../components/CustomersList"

const DisplayCustomers = () => {
    const SAMPLE_CUSTOMERS = [
      { id: 1, name: "Ash", account_id: 1 },
      { id: 2, name: "Ash", account_id:  2 },
      { id: 3, name: "Ash", account_id:  1 },
      { id: 4, name: "Ash", account_id:  2 },
      { id: 5, name: "Ash", account_id: 1 },
      { id: 6, name: "Ash", account_id: 3},
      { id: 7, name: "Ash", account_id:  1 },
      { id: 8, name: "Ash", account_id:  2 },
    ];

    return (
        <CustomersList customers={SAMPLE_CUSTOMERS} />
    )
}

export default DisplayCustomers