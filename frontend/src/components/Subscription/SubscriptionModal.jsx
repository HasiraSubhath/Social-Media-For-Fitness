import React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Modal from "@mui/material/Modal";
import IconButton from "@mui/material/IconButton";
import CloseIcon from "@mui/icons-material/Close";
import VerifiedIcon from "@mui/icons-material/Verified";
import FiberManualRecordIcon from "@mui/icons-material/FiberManualRecord";

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 600,
  bgcolor: "background.paper",
  border: "none",
  boxShadow: 24,
  p: 4,
  outline: "none",
  borderRadius: 4,
};

const SubscriptionModal = ({ handleClose, open }) => {
  const [plan, setPlan] = React.useState("Anually");
  const features = [
    "Access to all fitness content",
    "Access to all meal plans",
    "Access to all workout plans",
    "Access to all fitness challenges",
    "Access to all fitness events",
    "Access to all fitness courses",
  ];

  return (
    <div>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <div className="flex items-center space-x-3">
            <IconButton onClick={handleClose} aria-label="delete">
              <CloseIcon />
            </IconButton>
          </div>
          <div className="flex justify-center py-10">
            <div className="w-[80%] space-y-10">
              <div className="bg-orange-100 p-5 rounded-md flex items-center justify-between shadow-lg">
                <h1 className="text-xl pr-5">
                  Subscribers with a consistent amount of fitness content will
                  get a verfied badge once approved.
                </h1>
                <VerifiedIcon style={{ fontSize: 60, color: "#f97316" }} />
              </div>
              <div className="flex justify-between border rounded-full px-5 py-3  border-gray-700">
                <div>
                  <span
                    onClick={() => setPlan("Anually")}
                    className={`${
                      plan === "Anually" ? "text-orange-600" : "text-gray-500"
                    } cursor-pointer`}
                  >
                    Anually
                  </span>
                  &nbsp;
                  <span className="text-green-500 text-sm ml-5">Save 15%</span>
                </div>

                <p
                  onClick={() => setPlan("Monthly")}
                  className={`${
                    plan === "Monthly" ? "text-orange-600" : "text-gray-500"
                  } cursor-pointer`}
                >
                  Monthly
                </p>
              </div>
              <div className="space-y-3">
                {features.map((item) => (
                  <div className="flex items-center space-x-5 ">
                    <FiberManualRecordIcon
                      sx={{ width: "7px", height: "7px" }}
                    />
                    <p className="text-xs">{item}</p>
                  </div>
                ))}
              </div>
              <div className="cursor-pointer flex justify-center bg-gray-800 text-white rounded-full px-5 py-3">
                <span className="line-through italic">LKR 6999.99</span>
                <span className="text-3xl font-bold ml-5">
                  {plan === "Anually" ? "LKR 5999.99" : "LKR 999.99"}
                </span>
              </div>
            </div>
          </div>
        </Box>
      </Modal>
    </div>
  );
};

export default SubscriptionModal;
