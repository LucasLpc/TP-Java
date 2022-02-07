import { useEffect, useState } from "react";
import "./Pomodoro.css";

const Pomodoro = () => {
  const [workTime, setWorkTime] = useState(25);
  const [pauseTime, setPauseTime] = useState(5);
  const [minutes, setMinutes] = useState(workTime);
  const [seconds, setSeconds] = useState(0);
  const [mode, setMode] = useState("work");
  const [isPlaying, setIsPlaying] = useState(false);
  const [numberMS, setNumberMS] = useState(0);
  const [disbleMoreWorkTime, setDisbleMoreWorkTime] = useState(false);
  const [disbleMorePauseTime, setDisbleMorePauseTime] = useState(false);
  const [disbleLessWorkTime, setDisbleLessWorkTime] = useState(false);
  const [disbleLessPauseTime, setDisbleLessPauseTime] = useState(false);

  useEffect(() => {
    if (isPlaying) {
      const timer = setInterval(() => {
        clearInterval(timer);
        setNumberMS(numberMS + 1);
        if (numberMS % 100 === 0) {
          if (minutes === 0 && seconds === 0) {
            if (mode === "work") {
              setMode("pause");
              setMinutes(pauseTime);
              setSeconds(0);
            } else {
              setMode("work");
              setMinutes(workTime);
              setSeconds(0);
            }
          } else {
            if (seconds === 0) {
              setMinutes(minutes - 1);
              setSeconds(59);
            } else {
              setSeconds(seconds - 1);
            }
          }
        }
      }, 10);
    }
  }, [seconds, minutes, isPlaying, numberMS, workTime, pauseTime, mode]);

  const minutesText = minutes < 10 ? "0" + String(minutes) : String(minutes);
  const secondsText = seconds < 10 ? "0" + String(seconds) : String(seconds);
  const title = mode === "work" ? "Work" : "Pause";

  return (
    <div className="pomodoro">
      <div className="pomodoro__wrapper">
        <h1 className="pomodoro__title">{title}</h1>
        <div>
          <span className="pomodoro__timer timer-font">
            {minutesText} : {secondsText}
          </span>
          <div className="pomodoro__main-buttons">
            <button
              className="button"
              onClick={() => {
                setIsPlaying(true);
              }}
            >
              Play
            </button>
            <button
              className="button"
              onClick={() => {
                setIsPlaying(false);
              }}
            >
              Pause
            </button>
          </div>
        </div>
        <div className="pomodoro__options">
          <div className="pomodoro__option">
            <span className="pomodoro__option__title">Work</span>
            <div className="pomodoro__option__buttons">
              <button
                className="button round"
                disabled={disbleMoreWorkTime}
                onClick={() => {
                  if (workTime + 1 === 60) setDisbleMoreWorkTime(true);
                  if (workTime + 1 >= 2 && disbleLessWorkTime)
                    setDisbleLessWorkTime(false);
                  setWorkTime(workTime + 1);
                }}
              >
                +
              </button>
              <span>{workTime}</span>
              <button
                className="button round"
                disabled={disbleLessWorkTime}
                onClick={() => {
                  if (workTime - 1 === 1) setDisbleLessWorkTime(true);
                  if (workTime - 1 <= 59 && disbleMoreWorkTime)
                    setDisbleMoreWorkTime(false);
                  setWorkTime(workTime - 1);
                }}
              >
                -
              </button>
            </div>
          </div>
          <div className="pomodoro__option">
            <span className="pomodoro__option__title">Pause</span>
            <div className="pomodoro__option__buttons">
              <button
                className="button round"
                disabled={disbleMorePauseTime}
                onClick={() => {
                  if (pauseTime + 1 === 60) setDisbleMorePauseTime(true);
                  if (pauseTime + 1 >= 2 && disbleLessPauseTime)
                    setDisbleLessPauseTime(false);
                  setPauseTime(pauseTime + 1);
                }}
              >
                +
              </button>
              <span>{pauseTime}</span>
              <button
                className="button round"
                disabled={disbleLessPauseTime}
                onClick={() => {
                  if (pauseTime - 1 === 1) setDisbleLessPauseTime(true);
                  if (pauseTime - 1 <= 59 && setDisbleMorePauseTime)
                    setDisbleMorePauseTime(false);
                  setPauseTime(pauseTime - 1);
                }}
              >
                -
              </button>
            </div>
          </div>
        </div>
        <div className="pomodoro__restart">
          <button
            className="button"
            onClick={() => {
              setIsPlaying(false);
              if (mode === "work") {
                setMinutes(workTime);
                setSeconds(0);
              } else {
                setMinutes(pauseTime);
                setSeconds(0);
              }
            }}
          >
            Restart
          </button>
        </div>
      </div>
    </div>
  );
};

export default Pomodoro;
