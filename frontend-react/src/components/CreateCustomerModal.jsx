import CreateCustomerForm from "./CreateCustomerForm";
import Modal from "react-modal";
import "../styles/modal.css";

const CreateCustomerModal = ({ isOpen, closeModal }) => {
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
          <h2>Create Customer</h2>
        </div>

        <div className="modal-body">
          <CreateCustomerForm closeModal={closeModal}/>
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

export default CreateCustomerModal;
