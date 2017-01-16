function check(formID) {
    var pattern = null;
        
    switch(formID){
        case 'name':
            pattern =  new RegExp('(^[A-Z]?[a-z]{1,15}$)|(^[А-Я]?[а-я]{1,15}$)', '');
            break;
                
        case 'surname':
            pattern =  new RegExp('(^[A-Z]?[a-z]{1,15}$)|(^[А-Я]?[а-я]{1,15}$)', '');
            break;
                
        case 'login':
            pattern =  new RegExp('(^[a-zA-Z0-9]{3,15}$)', '');
            break;
                
        case 'password':
            pattern =  new RegExp('^[a-zA-Z0-9_\\*\\!\\^]{6,15}$', '');
            break;
            
        case 'email':
            pattern =  new RegExp('^[a-z0-9\\.]{3,25}@[a-z\\.]{3,10}\\.{1}[a-z]{2,5}$', '');
            break;
            
        case 'phone':
            if(document.getElementById(formID + 'Form').value == '') {
                document.getElementById(formID).style.color = '#2BC6A4';
                return;
            }
            pattern =  new RegExp('^(\\+\\d{3}\\s\\d{2})?\\s?\\d{3}(-|\\s)?\\d{2}(-|\\s)?\\d{2}$', '');
            break;
    }
        
    inputStr = document.getElementById(formID + 'Form').value;
        
    if(pattern.test(inputStr)) {
        document.getElementById(formID).style.color = '#2BC6A4';
    } else {
        document.getElementById(formID).style.color = '#FF3D3D';
    }
}