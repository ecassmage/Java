public class Date {
    int day, month, year;
    public static void main(String[] args){
        Date date = new Date("04 10 2001", "MDY");
        date.PrintDate("MDY", '\0');
    }
    public Date(String date, String order){
        //String date wants a string with a date in it. Month Day and Year need to be split for it to work.
        //order just means Something like "MDY" or "DYM" D for Day, M for Month and Y for Year
        int ptrOrder = 0;
        int number = 0;
        for (int ptrDate = 0; ptrDate <= date.length(); ptrDate++){
            if (ptrDate == date.length() || 58 < date.charAt(ptrDate) || date.charAt(ptrDate) < 48){
                if (order.charAt(ptrOrder) == 'D'){
                    this.day = number;
                }
                else if (order.charAt(ptrOrder) == 'M'){
                    this.month = number;
                }
                else if (order.charAt(ptrOrder) == 'Y'){
                    this.year = number;
                }
                number = 0;
                ptrOrder++;
                continue;
            }
            number = (number * 10) + (date.charAt(ptrDate) - 48);
        }
    }
    public void PrintDate(String DateFormat, char dividerSymbol){
        int loadNumber = 0;
        for (int i = 0; i < 3; i++){
            if (DateFormat.charAt(i) == 'D'){
                loadNumber = this.day;
            }
            else if (DateFormat.charAt(i) == 'M'){
                loadNumber = this.month;
            }
            else if (DateFormat.charAt(i) == 'Y'){
                loadNumber = this.year;
            }
            else loadNumber = 0;
            System.out.print(loadNumber);
            if (i != 2) System.out.print(dividerSymbol);
        }
        System.out.print("\n");
    }
}
