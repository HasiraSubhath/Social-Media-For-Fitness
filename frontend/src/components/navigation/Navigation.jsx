import React from "react";
import { navigationMenu } from "./NavigationMenu";
import { useNavigate } from "react-router-dom";
import { Avatar, Button, Menu, MenuItem } from "@mui/material";
import MoreHorizIcon from "@mui/icons-material/MoreHoriz";

const Navigation = () => {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };
  const navigate = useNavigate();
  const handleLogout = () => {
    handleClose();
  };
  return (
    <div className="h-screen sticky top-0">
      <div>
        <div className="py-5">
          <img src="images/logo.svg" alt="" />
        </div>
        <div className="space-y-6">
          {navigationMenu.map((item, index) => {
            const IconComponent = item.icon;
            return (
              <div
                key={index}
                className="cursor-pointer flex space-x-3 items-center"
                onClick={() =>
                  item.title === "Profile"
                    ? navigate(`/profile/${5}`)
                    : navigate(item.path)
                }
              >
                <IconComponent />
                <p className="text-xl">{item.title}</p>
              </div>
            );
          })}
        </div>
        <div className="py-10">
          <Button
            sx={{
              width: "75%",
              borderRadius: "29px",
              py: "15px",
              bgcolor: "#f97316",
              "&:hover": {
                bgcolor: "#7c2d12",
              },
            }}
            variant="contained"
          >
            Boost
          </Button>
        </div>
      </div>
      <div className="flex items-center justify-between">
        <div className="flex items-center space-x-3">
          <Avatar alt="username" src="../images/avatar.svg" />
          <div className="flex flex-col">
            <span>Sahan Pallage</span>
            <span className="opacity-70">@sahannn.r</span>
          </div>
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
            <MenuItem onClick={handleLogout}>Logout</MenuItem>
          </Menu>
        </div>
      </div>
    </div>
  );
};

export default Navigation;
