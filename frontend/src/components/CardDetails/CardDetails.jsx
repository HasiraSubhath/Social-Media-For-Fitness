import React from "react";
import KeyboardBackspaceIcon from "@mui/icons-material/KeyboardBackspace";
import { useNavigate } from "react-router-dom";
import Card from "../HomeSection/Card";
import { Divider } from "@mui/material";

const CardDetails = () => {
  const navigate = useNavigate();
  const handleBack = () => navigate(-1);
  return (
    <React.Fragment>
      <section
        className={`z-50 flex items-center sticky top-0 bg-white bg-opacity-95`}
      >
        <KeyboardBackspaceIcon
          className="cursor-pointer"
          onClick={handleBack}
        />
        <h1 className="text-xl font-bold ml-5 py-5 opacity-90">Boost</h1>
      </section>
      <section>
        <Card />
        <Divider sx={{ margin: "2rem 0rem" }} />
      </section>
      <section>
        {[1, 1, 1, 1].map((item) => (
          <Card />
        ))}
      </section>
    </React.Fragment>
  );
};

export default CardDetails;
