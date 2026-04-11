import CreateCustomerForm from "./CreateCustomerForm";
import Modal from "react-modal";

const CreateCustomerModal = ({ isOpen, closeModal }) => {
  return (
    <>
      <Modal isOpen={isOpen} onRequestClose={closeModal}>
        <CreateCustomerForm />
        <button type="button" onClick={closeModal}>Close</button>
      </Modal>
    </>
  );
}

export default CreateCustomerModal;
