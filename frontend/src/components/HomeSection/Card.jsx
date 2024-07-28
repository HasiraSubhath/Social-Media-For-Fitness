import React, { useState } from "react";
import RepeatIcon from "@mui/icons-material/Repeat";
import { Avatar, Button, Menu, MenuItem } from "@mui/material";
import { useNavigate } from "react-router-dom";
import VerifiedIcon from "@mui/icons-material/Verified";
import MoreHorizIcon from "@mui/icons-material/MoreHoriz";
import ChatBubbleOutlineIcon from "@mui/icons-material/ChatBubbleOutline";
import FavoriteIcon from "@mui/icons-material/Favorite";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import FileUploadIcon from "@mui/icons-material/FileUpload";
import BarChartIcon from "@mui/icons-material/BarChart";
import ReplyModal from "./ReplyModal";

const Card = () => {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const [openReplyModal, setOpenReplyModal] = useState(false);
  const handleOpenReplyModal = () => setOpenReplyModal(true);
  const handleCloseReplyModal = () => setOpenReplyModal(false);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };
  const navigate = useNavigate();
  const handleDeletePost = (event) => {
    handleClose();
  };
  const handleEditPost = (event) => {};
  const handleCreateReboost = (event) => {};
  const handleLikeBoost = (event) => {};
  return (
    <React.Fragment>
      {/* <div className="flex items-center font-semibold text-gray-700 py-2">
        <RepeatIcon />
        <p>You Reboost</p>
      </div> */}

      <div className="flex space-x-5">
        <Avatar
          onClick={() => navigate(`/profile/${5}`)}
          className="cursor-pointer"
          alt="username"
          src="../images/avatar.svg"
        />
        <div className="w-full">
          <div className="flex justify-between items-center">
            <div className="flex cursor-pointer items-center space-x-2">
              <span className="font-semibold">Sahan Pallage</span>
              <span className="opacity-70">@sahannn.r . 2m</span>
              <VerifiedIcon className="text-[#f97316]" />
            </div>
            <div>
              <Button
                id="basic-button"
                aria-controls={open ? "basic-menu" : undefined}
                aria-haspopup="true"
                aria-expanded={open ? "true" : undefined}
                onClick={handleClick}
              >
                <MoreHorizIcon />
              </Button>
              <Menu
                id="basic-menu"
                anchorEl={anchorEl}
                open={open}
                onClose={handleClose}
                MenuListProps={{
                  "aria-labelledby": "basic-button",
                }}
              >
                <MenuItem onClick={handleEditPost}>Edit</MenuItem>
                <MenuItem onClick={handleDeletePost}>Delete</MenuItem>
              </Menu>
            </div>
          </div>
          <div className="mt-2">
            <div
              onClick={() => navigate(`/boost/${3}`)}
              className="cursor-pointer"
            >
              <p className="mb-2 p-0">
                Lorem ipsum dolor, sit amet consectetur adipisicing elit. Sint
                sit ex quod quas impedit tempore, officia exercitationem
                deserunt labore error nesciunt amet explicabo deleniti nemo
                porro. Accusamus, tempora provident. Quibusdam?
              </p>
              <img
                className="w-[28rem] border border-gray-400 p-5 rounded-md"
                src="https://images.pexels.com/photos/841130/pexels-photo-841130.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                alt=""
              />
            </div>
            <div className="py-5 flex flex-wrap justify-between items-center">
              <div className="space-x-3 flex items-center text-gray-600">
                <ChatBubbleOutlineIcon
                  className="cursor-pointer"
                  onClick={handleOpenReplyModal}
                />
                <p>50</p>
              </div>
              <div
                className={`${
                  true ? "text-orange-600" : "text-gray-600"
                } space-x-3 flex items-center`}
              >
                <RepeatIcon
                  onClick={handleCreateReboost}
                  className="cursor-pointer"
                />
                <p>65</p>
              </div>
              <div
                className={`${
                  true ? "text-orange-600" : "text-gray-600"
                } space-x-3 flex items-center`}
              >
                {true ? (
                  <FavoriteIcon
                    onClick={handleLikeBoost}
                    className="cursor-pointer"
                  />
                ) : (
                  <FavoriteBorderIcon
                    onClick={handleLikeBoost}
                    className="cursor-pointer"
                  />
                )}
                <p>65</p>
              </div>
              <div className="space-x-3 flex items-center text-gray-600">
                <BarChartIcon className="cursor-pointer" />
                <p>450</p>
              </div>
              <div className="space-x-3 flex items-center text-gray-600">
                <FileUploadIcon
                  className="cursor-pointer"
                  onClick={handleOpenReplyModal}
                />
              </div>
            </div>
          </div>
        </div>
      </div>
      <section>
        <ReplyModal open={openReplyModal} handleClose={handleCloseReplyModal} />
      </section>
    </React.Fragment>
  );
};

export default Card;
