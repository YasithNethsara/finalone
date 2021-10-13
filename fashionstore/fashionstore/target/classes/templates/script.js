const feedback = document.getElementById('feedback')
const helpfull = document.getElementById('helpfull')
const form = document.getElementById('form')
const errorElement = document.getElementById('error')

form.addEventListener('submit',(e)=>{
	
	let messages =[]
	if(feedback.value === ''|| name.value == null){
		
		messages.push('Feedback is required')
	}
	
	if(message.length > 0 ){
		e.preventDefault()
		errorElement.innerText = message.join(', ')
	}
	
}
)


function clearSearch() {
		window.location = "[[@{/}]]";
	}






function addClass() {
  document.body.classList.add("sent");
}

sendLetter.addEventListener("click", addClass);

/**
 * 
 */