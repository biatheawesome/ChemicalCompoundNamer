package sample;

public class CompoundNamer {
    public String giveName(String compound) {

        String name;
        String[] splitCompound;
        String[] firstAtom = new String[]{"P","S","C","N","Li", "Be", "Na", "Mg", "Al", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Rb", "Sn", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Cs", "Ba", "Pt", "Au", "Hg", "Pb", "Bi"};
        String[] firstAtomName = new String[]{"Phosphorus","Sulphur","Carbon","Nitrous","Lithium", "Beryllium", "Sodium", "Magnesium", "Aluminum", "Potassium", "Calcium", "Scandium", "Titanium", "Vanadium", "Chromium", "Manganese", "Iron", "Cobalt", "Nickel", "Copper", "Zinc", "Gallium", "Rubidium", "Strontium", "Yttrium", "Zirconium", "Niobium", "Molybdenum", "Technetium", "Ruthenium", "Rhodium", "Palladium", "Silver", "Cadmium", "Indium", "Tin", "Cesium", "Barium", "Platinum", "Gold", "Mercury", "Lead", "Bismuth"};
        String[] secondAtom = new String[]{"NO3", "SO4", "CO3", "PO4", "C", "N", "F", "P", "S", "Cl", "Se", "Br", "I","O2","CN","NO2","HCO3","SO3","ClO","ClO2","ClO3","ClO4"};
        String[] secondAtomName = new String[]{"nitrate", "sulphate", "carbonate", "phosphate", "carbide", "nitride", "fluoride", "phosphide", "sulfide", "chloride", "selenide", "bromide", "iodide","peroxide","cyanide","nitrite","bicarbonate","sulphite","hypochlorite","chlorite","chlorate","perchlorate"};
        String[] hydroxide = new String[]{"OH", "hydroxide"};
        String[] hydracid = new String[]{"H", "hydro", "ic", "acid"};
        String[] n_oxide=new String[]{"O","O2","O3","O4","O5"};
        String[] n_oxideName=new String[]{"monoxide","dioxide","trioxide","tetraoxide","pentoxide","oxide"};
        String temp1="";
        String temp2="";
        boolean acid = false;
        boolean base = false;
        boolean oxide= false;

        if(compound.matches("[A-Z]+[a-z]?[A-Z]+[a-z]?\\d?")) {
            splitCompound = compound.split("((?=\\p{Lu}))",2);
        } else {
                splitCompound = compound.split("(\\d)", 2);
        }

            for (int i = 0; i < firstAtom.length; i++) {
                if (splitCompound[0].equals(firstAtom[i])) {
                    temp1 = firstAtomName[i];
                    break;

                }
                if (splitCompound[0].equals(hydracid[0])) {
                    acid = true;
                    break;
                }
            }
            for(int i=0; i<secondAtom.length; i++) {
                if (splitCompound[1].equals(secondAtom[i])) {
                    temp2=secondAtomName[i];
                    break;
                }
                if (splitCompound[1].contains(hydroxide[0]) || compound.equals("NH3")) {
                    base = true;
                    break;
                }
            }
            for(int i=0; i<n_oxide.length; i++) {
                if(splitCompound[1].equals(n_oxide[i])) {
                    oxide=true;
                    break;
                }
            }

            if(oxide) {
                if(!temp1.equalsIgnoreCase("carbon")&& !temp1.equalsIgnoreCase("nitrous")&& !temp1.equalsIgnoreCase("sulphur")&& !temp1.equalsIgnoreCase("phosphorus")) {
                    temp2=n_oxideName[5];
                } else {
                    for(int i=0; i<n_oxide.length; i++) {
                        if(splitCompound[1].equals(n_oxide[i])) {
                            temp2=n_oxideName[i];
                            break;
                        }
                    }
                }
            }

            if(acid) {
                if(compound.equals("HCl")) {
                    name="hydrochloric acid";
                } else {
                    if
                    (compound.equals("H2SO4")) {
                        name="sulphuric acid";
                    } else {
                        temp2=temp2.substring(0, temp2.length()-3);
                        name=temp2+hydracid[2]+" "+hydracid[3];
                    }
                }
            } else {
                if(base) {
                    if(compound.equals("NH3")) {
                        name="ammonia";
                    }else {
                        name=temp1+" "+hydroxide[1];
                    }
                } else {
                    name=temp1+" "+temp2;
                }
            }
        if(compound.equals("H2O")) {
            name="water";
        }
        return name;
    }
    public String giveInfo(String compound) {
        if(compound.charAt(0)=='H') {
            return "Acid";
        } else {
            if(compound.matches("[A-Z]+[a-z]?\\d?[O]\\d?")) {
                return "Oxide";
            } else {
                if(compound.matches("[A-Z]+[a-z]?\\d?[(]?[O][H][)]?\\d?") || compound.equals("NH3")) {
                    return "Base";
                } else {
                    if(compound.equals("H2O")) {
                        return "Water";
                    } else {
                        return "Ionic compound";
                    }
                }
            }
        }

    }
}
