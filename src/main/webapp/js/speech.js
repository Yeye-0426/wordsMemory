const synth = window.speechSynthesis;

const inputForm = document.querySelector("#speech-form");
const inputTxt = document.querySelector(".txt");

const selectedVoice = "Microsoft Aria Online (Natural) - English (United States) (en-US)";
const pitchValue = 1.0;
const rateValue = 1.0;

let voices = [];

function speak() {
  if (synth.speaking) {
    console.error("speechSynthesis.speaking");
    return;
  }

  if (inputTxt.value !== "") {
    const utterThis = new SpeechSynthesisUtterance(inputTxt.value);

    utterThis.onend = function (event) {
      console.log("SpeechSynthesisUtterance.onend");
    };

    utterThis.onerror = function (event) {
      console.error("SpeechSynthesisUtterance.onerror");
    };

    for (let i = 0; i < voices.length; i++) {
      if (voices[i].name === selectedVoice) {
        utterThis.voice = voices[i];
        break;
      }
    }
    utterThis.pitch = pitchValue;
    utterThis.rate = rateValue;
    synth.speak(utterThis);
  }
}

inputForm.onsubmit = function (event) {
  event.preventDefault();

  speak();

  inputTxt.blur();
};
