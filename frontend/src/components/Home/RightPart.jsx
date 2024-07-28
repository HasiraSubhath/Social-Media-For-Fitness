import React from "react";
import SearchIcon from "@mui/icons-material/Search";
import Brightness6Icon from "@mui/icons-material/Brightness6";
import { Button } from "@mui/material";
import MoreHorizIcon from "@mui/icons-material/MoreHoriz";
import SubscriptionModal from "../Subscription/SubscriptionModal";

const RightPart = () => {
  const [openSubscriptionModal, setOpenSubscriptionModal] =
    React.useState(false);
  const handleOpenSubscriptionModal = () => setOpenSubscriptionModal(true);
  const handleCloseSubscriptionModal = () => setOpenSubscriptionModal(false);
  const handleChangeTheme = () => {
    document.body.classList.toggle("dark");
  };
  return (
    <div className="py-5 sticky top">
      <div className="relative flex items-center">
        <input
          className="py-3 rounded-full text-gray-500 w-full pl-12"
          type="text"
        />
        <div className="absolute top-0 left-0 pl-3 pt-3">
          <SearchIcon className="text-gray-500" />
        </div>
        <Brightness6Icon
          className="ml-3 cursor-pointer"
          onClick={handleChangeTheme}
        />
      </div>
      <section className="my-5">
        <h1 className="text-xl font-bold">Get Verified</h1>
        <h1 className="font-bold my-2">Explore more fitness energy!</h1>
        <Button
          onClick={handleOpenSubscriptionModal}
          variant="contained"
          sx={{
            padding: "10px",
            paddingX: "20px",
            borderRadius: "25px",
            bgcolor: "#f97316",
            "&:hover": {
              bgcolor: "#7c2d12",
            },
          }}
        >
          Get Verified
        </Button>
      </section>
      <section className="mt-7 space-y-5">
        <h1 className="font-bold text-xl py-1">What's happening</h1>
        {[1, 1, 1, 1].map((item) => (
          <div className="flex justify-between w-full">
            <div>
              <p className="text-sm">Fitness • Trending</p>
              <p className="font-bold">#TheMealPlan </p>
              <p>35.2k Reboosts</p>
            </div>
            <MoreHorizIcon />
          </div>
        ))}
      </section>
      <section>
        <SubscriptionModal
          open={openSubscriptionModal}
          handleClose={handleCloseSubscriptionModal}
        />
      </section>
    </div>
  );
};

export default RightPart;
