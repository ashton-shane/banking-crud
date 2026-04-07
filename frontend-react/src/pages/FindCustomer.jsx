import FindById from "../components/FindById";

const findCustomer = () => {
    const fakeFetchCustomer = async (id) => {
        await new Promise((res) => setTimeout(res, 300));
        return { id, name: `Customer ${id}`, accounts: [ { id: 1, balance: 100 }, { id: 2, balance: 200 } ] };
    };

    return (
        <FindById id={1} onFind={fakeFetchCustomer} />
    )
}

export default findCustomer