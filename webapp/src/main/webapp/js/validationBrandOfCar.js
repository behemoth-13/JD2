function check(formID) {
    var inputStr = document.getElementById(formID + 'Form').value;
    if (formID == 'brand_of_car') {
        var pattern = new RegExp('(^[a-zA-ZА-Яа-я0-9 ]{3,45}$)', '');
        if(pattern.test(inputStr)) {
            document.getElementById(formID).style.color = '#2BC6A4';
        } else {
            document.getElementById(formID).style.color = '#FF3D3D';
        }
    } else {
        var result = false;

        switch(formID){
            case 'loadingCapacity':
                if (inputStr >= 100 && inputStr <= 44000){
                    result = true;
                }
                break;

            case 'capacity':
                if (inputStr >= 1 && inputStr <= 200){
                    result = true;
                }
                break;

            case 'cost_per_km':
                if (inputStr > 0){
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
}
