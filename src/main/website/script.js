let randomNumber = Math.floor(Math.random() * 100) + 1;

const guesses = document.querySelector('.guesses');
const lastResult = document.querySelector('.lastResult');
const lowOrHi = document.querySelector('.lowOrHi');

const guessSubmit = document.querySelector('.guessSubmit');
const guessField = document.querySelector('.guessField');

const API_KEY = "apiKey=ISInl5K4qBsXsxmqM4qm4V3wX5fgndxx";

const URL = "https://api.giphy.com/v1";

const RANDOM_END_POINT = "/gifs/random?";

let guessCount = 1;
let resetButton;

function checkGuess() {
  let userGuess = Number(guessField.value);
  if (guessCount === 1) {
    guesses.textContent = 'Previous guesses: ';
  }
  guesses.textContent += userGuess + ' ';

  if (userGuess === randomNumber) {
    lastResult.textContent = 'Congratulations! You got it right!';
    lastResult.style.backgroundColor = 'green';
    lowOrHi.textContent = '';
    setGameOver();
  } else if (guessCount === 10) {
    lastResult.textContent = '!!!GAME OVER!!!';
    setGameOver();
  } else {
    lastResult.textContent = 'Wrong!';
    lastResult.style.backgroundColor = 'red';
    if(userGuess < randomNumber) {
      lowOrHi.textContent = 'Last guess was too low!';
    } else if(userGuess > randomNumber) {
      lowOrHi.textContent = 'Last guess was too high!';
    }
  }

  guessCount++;
  guessField.value = '';
  guessField.focus();
}

guessSubmit.addEventListener('click', checkGuess);

function setGameOver() {
  guessField.disabled = true;
  guessSubmit.disabled = true;
  resetButton = document.createElement('button');
  resetButton.textContent = 'Start new game';
  document.body.appendChild(resetButton);
  resetButton.addEventListener('click', resetGame);
}

function getGif() {
  // we create a new instance of an HTTP request
  var request = new XMLHttpRequest();
  //we get the text that the user has typed in
  searchTerm = document.getElementById('input-box').value;
  // we set up the url endpoint we want to reach
  var searchQuery = "&tag=" + searchTerm;
  var requestUrl = URL + RANDOM_END_POINT + API_KEY + searchQuery;

  // we make the request
  request.open('GET', requestUrl);
  request.responseType = 'json';
  request.send();

  //we do something with the successful response
  request.onload = function() {
    var response = request.response;
    var imageUrl  = response.data.image_url;
    document.getElementById('gif').src = imageUrl
  }
}