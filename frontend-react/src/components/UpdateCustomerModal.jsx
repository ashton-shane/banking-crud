import UpdateCustomerForm from "./UpdateCustomerForm";
import Modal from "react-modal";
import "../styles/modal.css";

const UpdateCustomerModal = ({ isOpen, closeModal, customer }) => {
  return (
    <>
      <Modal
        isOpen={isOpen}
        onRequestClose={closeModal}
        overlayClassName="react-modal-overlay"
        className="react-modal-content"
        contentLabel="Create Customer"
      >
        <div className="modal-header">
          <h2>Update Customer Id {customer.id}</h2>
        </div>

        <div className="modal-body">
          <UpdateCustomerForm 
            closeModal={closeModal}
            customer={customer}/>
        </div>

        <div className="modal-footer">
          <button
            type="button"
            className="btn btn-secondary modal-close-btn"
            onClick={closeModal}
          >
            Close
          </button>
        </div>
      </Modal>
    </>
  );
};

export default UpdateCustomerModal;
