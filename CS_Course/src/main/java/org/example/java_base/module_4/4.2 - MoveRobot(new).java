/*

// 4.2 - реализовать метод который устанавливает соединение с роботом,
// отдает ему команду на перемещение в заданную точку и затем закрывает соединение,
// выполняя при необходимости повтор этой последовательности до трех раз.

public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
  RobotConnection robot = null;
        boolean needToClose = true;
        for (int i=0; i<3; i++) {
            try {
                robot = robotConnectionManager.getConnection();
                robot.moveRobotTo(toX, toY);
                return;
            }
            catch (RobotConnectionException e) {
                if(i==2){
                    if (robot != null)
                        robot.close();
                    needToClose = false;
                    throw e;
                }
            }
            catch (Exception ex) {
                try{
                    if ((robot != null) && needToClose){
                        robot.close();
                        needToClose = false;
                    }
                }
                catch(Exception exp){
                    
                }
                throw ex;
            }
            finally {
                try{
                    if ((robot != null) && needToClose)
                        robot.close();
                }
                catch(Exception exp){
                   
                }

            }
        }

    }
*/