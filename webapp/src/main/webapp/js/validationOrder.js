function check(formID) {
	var inputStr = document.getElementById(formID + 'Form').value;
    var result = false;
        
    switch(formID){
        case 'weight':
        	if (inputStr >= 0 && inputStr <= 200){
        		result = true;
        	}
            break;
                
        case 'capacity':
        	if (inputStr >= 0 && inputStr <= 800){
        		result = true;
        	}
            break;
            
        case 'distance':
        	if (inputStr >= 20 && inputStr <= 10000){
        		result = true;
        	}
        	break;
    }
        
    if(result) {
        document.getElementById(formID).style.color = '#2BC6A4';
    } else {
        document.getElementById(formID).style.color = '#FF3D3D';
    }
}